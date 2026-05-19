#!/bin/bash
DIR="/home/admin/Desktop/FiveGuys/Deployment/Log"
LOG="$DIR/status.txt"
mkdir -p "$DIR"

if /usr/bin/pgrep -f fiveguys-0.0.1-SNAPSHOT.jar > /dev/null 2>&1; then
    echo "$(date '+%m/%d/%Y %I:%M:%S %p') :Application-feedback is running" >> "$LOG"
else
    echo "$(date '+%m/%d/%Y %I:%M:%S %p') :restarting application-feedback." >> "$LOG"
fi
