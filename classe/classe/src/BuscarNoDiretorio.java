import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class BuscarNoDiretorio {

    public static List<String> procurarClasse(String nomeDaClasse, String caminhoDoDiretorio, boolean flagParallelStream) {
        List<String> locaisEncontrados = new ArrayList<>();
        File diretorio = new File(caminhoDoDiretorio);

        if (!diretorio.exists()) {
            System.out.println("O diretório especificado não existe.");
            return locaisEncontrados;
        }

        try {
            buscarNoDiretorio(diretorio, nomeDaClasse, locaisEncontrados, flagParallelStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return locaisEncontrados;
    }

    private static void buscarNoDiretorio(File diretorio, String nomeClasse, List<String> locaisEncontrados, boolean flagParallelStream) throws IOException {
        Stream<File> fileStream = flagParallelStream ? findFilesParallel(diretorio) : findFiles(diretorio);

        fileStream.forEach(file -> {
            if (file.isDirectory()) {
                try {
                    buscarNoDiretorio(file, nomeClasse, locaisEncontrados, flagParallelStream);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else if (file.getName().endsWith(".class")) {
                String filePath = file.getAbsolutePath();

                if (file.getName().contains(nomeClasse)) {
                    locaisEncontrados.add(filePath);
                }
            } else if (file.getName().endsWith(".jar") || file.getName().endsWith(".war")) {
                List<String> classesInArchive = procurarClassesNoArquivo(file, nomeClasse);
                locaisEncontrados.addAll(classesInArchive);
            }
        });
    }

    private static List<String> procurarClassesNoArquivo(File arquivo, String nomeClasse) {
        List<String> locaisEncontrados = new ArrayList<>();

        try {
            ZipFile zipFile = arquivo.getName().endsWith(".jar") ? new ZipFile(arquivo) : null;
            Optional.ofNullable(zipFile)
                    .or(() -> arquivo.getName().endsWith(".war") ? Optional.of(new ZipFile(arquivo)) : Optional.empty())
                    .ifPresent(zf -> {
                        Enumeration<? extends ZipEntry> entries = zf.entries();
                        verificarEntradasArquivo(arquivo, nomeClasse, locaisEncontrados, entries);
                        try {
                            zf.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return locaisEncontrados;
    }

    private static void verificarEntradasArquivo(File arquivo, String nomeDaClasse, List<String> locaisEncontrados, Enumeration<? extends ZipEntry> entries) {
        while (entries.hasMoreElements()) {
            ZipEntry entrada = entries.nextElement();
            if (entrada.getName().endsWith(".class")) {
                String qualifiedClassName = entrada.getName().replace("/", ".").replace(".class", "");
                if (qualifiedClassName.contains(nomeDaClasse)) {
                    locaisEncontrados.add(arquivo.getAbsolutePath() + " - " + qualifiedClassName);
                }
            }
        }
    }

    private static Stream<File> findFiles(File directory) throws IOException {
        return Stream.of(directory.listFiles());
    }

    private static Stream<File> findFilesParallel(File directory) throws IOException {
        return Stream.of(directory.listFiles()).parallel();
    }
}
