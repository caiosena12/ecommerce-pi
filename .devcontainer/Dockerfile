# especifca a imagem base
# intsla o ubunto com java e maven
FROM maven:3.9-eclipse-temurin-21-noble

# habilita a instalaçao nao interativa
ENV DEBIAN_FRONTEND=noninteractive

# instala as ferramentas que nao estao na imagem base
# apt-get upatde - atualiza os repositorios do software
# apt-get install - instala as ferramentas
# curl - testa as APIs
# git-lfs - armazenamento de arquivos binarios
RUN apt-get update && apt-get install -y \
    mysql-server-8.0 \
    git \
    git-lfs \
    curl \
    unzip \
    zip \
    && apt-get clean \
    && rm -rf /var/lib/apt/lists/*
