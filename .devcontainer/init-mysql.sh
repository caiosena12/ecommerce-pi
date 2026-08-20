#!/bin/bash

#se ocorrer erro o script aborda
set -e

#exibe uma mensagem no terminal
echo "Iniciando MySQL..."

#inicia o mysql
service mysql start

#verifica se o mysql ja iniciou, ele tenta pingar o mysql até 30 vezes
echo "Aguardando MySQL ficar pronto..."
for tentativa in $(seq 1 30); do
    if mysqladmin ping --silent; then
        echo "MySQL pronto."
        break
    fi
    sleep 1
done

# Se passou das 30 tentativas sem resposta, para o script com erro.
if ! mysqladmin ping --silent; then
    echo "Erro: MySQL não respondeu a tempo." >&2
    exit 1
fi

echo "Configurando banco..."

#envia para o mysql os comandos a seguir
#CHARACTER e COLLATE define a codificaçao dos caracteres
#CREATE USER - cria um usuario
#GRANT - atribui permissoes para o usuario
mysql <<EOF
CREATE DATABASE IF NOT EXISTS ecommerce
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

CREATE USER IF NOT EXISTS 'caio'@'%' IDENTIFIED BY '123@Mudar';

GRANT ALL PRIVILEGES ON ecommerce.* TO 'sergio'@'%';

FLUSH PRIVILEGES;
EOF

echo "MySQL configurado com sucesso!"
