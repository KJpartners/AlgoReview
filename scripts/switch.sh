#!/usr/bin/env bash

ABSPATH=$(readlink -f $0)
ABSDIR=$(dirname $ABSPATH)
source ${ABSDIR}/profile.sh

function switch_proxy() {
  IDLE_PORT=$(find_idle_port)

  echo "> 전환할 port: $IDLE_PORT"
  echo "> port 전환"
  # Nginx가 변경할 프록시 주소 생성해서 파이프라인으로 넘겨주기 위해 echo를 사용 | 덮어씌우기
  echo "set \$service_url http://43.201.226.45:${IDLE_PORT};" | sudo tee /etc/nginx/conf.d/service-url.inc

  echo "> Nginx Reload"
  sudo service nginx reload # restart(끊김 O) != reload(끊김 X)
}