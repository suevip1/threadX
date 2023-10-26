#!/bin/bash

# 定义应用程序的相关信息
APP_NAME="threadX-metrics-server"
VERSION="1.0"  # 请替换为你的应用程序版本号

# 定义应用程序的路径
APP_DIR="../lib"
CONFIG_DIR="../conf"
LOG_DIR="./logs"
JAR_FILE="$APP_DIR/$APP_NAME-${VERSION}.jar"
CONFIG_FILE="$CONFIG_DIR/application.properties"
LOG_CONFIG_FILE="$CONFIG_DIR/logback-spring.xml"

# 创建日志目录（如果不存在）
mkdir -p $LOG_DIR

# 定义JVM参数
# 请根据你的需求和硬件配置修改这些参数
JVM_XMS="2g"
JVM_XMX="2g"

# 启动应用程序并配置日志
java -Xms$JVM_XMS -Xmx$JVM_XMX -Dlogging.config=$LOG_CONFIG_FILE -jar $JAR_FILE --spring.config.location=file:$CONFIG_FILE >> $LOG_DIR/out.log 2>&1