#!/usr/bin/env bash

ABSPATH=$(readlink -f $0)
ABSDIR=$(dirname $ABSPATH)
source ${ABSDIR}/profile.sh # 여기서도 profile.sh 함수를 사용

PROJECT_ROOT="/home/ec2-user/app"
JAR_FILE="$PROJECT_ROOT/spring-webapp.jar"

APP_LOG="$PROJECT_ROOT/application.log"
ERROR_LOG="$PROJECT_ROOT/error.log"
DEPLOY_LOG="$PROJECT_ROOT/deploy.log"

TIME_NOW=$(date +%c)

# build 파일 복사
echo "$TIME_NOW > $JAR_FILE 파일 복사" >> $DEPLOY_LOG
cp $PROJECT_ROOT/build/libs/*.jar $JAR_FILE # 해당 경로의 모든 jar 파일을 $JAR_FILE 위치에 복사

IDLE_PROFILE=$(find_idle_profile)

# jar 파일을 profile=$IDLE_PROFILE로 실행
echo "$TIME_NOW > $JAR_FILE 을 profile=$IDLE_PROFILE 로 실행" >> $DEPLOY_LOG
nohup java -jar -Dspring.profiles.active=$IDLE_PROFILE $JAR_FILE > $APP_LOG 2> $ERROR_LOG &

#프로파일 명시
CURRENT_PID=$(pgrep -f $JAR_FILE)
echo "$TIME_NOW > 실행된 프로세스 아이디 $CURRENT_PID 입니다." >> $DEPLOY_LOG