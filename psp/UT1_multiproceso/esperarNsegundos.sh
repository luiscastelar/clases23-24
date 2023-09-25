#!/bin/bash
# Códigos de salida
#   0: ok
#   129: kill -1
#   137: kill -9
#   143: kill -15
#   255: falta 1 parámetro


echo "PID: $$"

if [[ $# -lt 1 ]]; then
    echo "Requiere 1 parámetro"
    exit 255;
else
    declare -i -r SECONDS=$1
fi
sleep $SECONDS
exit 0;
