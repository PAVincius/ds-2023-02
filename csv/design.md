# Design System

## Problema

Um software que lê um arquivo no formato CSV e, para cada linha, calcula a soma das duas primeiras colunas e gera um arquivo CSV, contendo as mesmas linhas, mas o arquivo gerado contém uma coluna adicional que a soma obtida para cada linha. 

## Ideação da Solução

1 - Seleciona arquivo csv
2 - Lê arquivo csv
3 - Soma as duas primerias colunas
4 - Salva resultado do item 3 em uma coluna na última coluna
5 - Exporta um arquivo CSV com os dados do csv lido + o resultado do item 4

## Sugestões de Solução

### R

```bash
#importing relevant Libraries
library(hablar)
# Choosing File
path <- file.choose()
# Reading CSV file
csv = read.csv('path')
#view result
csv 
# Hypothesizing Columns A and B names: A('a'), B('b')
csv$a <- as.numeric(csv$a)
csv$b <- as.numeric(csv$b)

```

### SQL

### Python