#!/usr/bin/env bash

ABSPATH=$(readlink -f $0) # 현재 스크립트 파일의 절대 경로
ABSDIR=$(dirname $ABSPATH) # 현재 스크립트 파일의 디렉토리 경로
source ${ABSDIR}/profile.sh # 자바 import와 비슷한 기능. profile.sh의 여러 함수 사용 가능

IDLE_PORT=$(find_idle_port)

TIME_NOW=$(date +%c)

# 현재 구동 중인 애플리케이션 pid 확인
echo "> $IDLE_PORT 에서 구동 중인 애플리케이션 pid 확인"
IDLE_PID=$(lsof -ti tcp:${IDLE_PORT})

# 프로세스가 켜져 있으면 종료
if[ -z ${IDLE_PID} ]
then
  echo "$TIME_NOW > 현재 구동 중인 애플리케이션이 없으므로 종료하지 않습니다."
else
  echo "$TIME_NOW > 실행중인 $IDLE_PID 애플리케이션 종료"
  kill -15 ${IDLE_PID}
  sleep 5
fi