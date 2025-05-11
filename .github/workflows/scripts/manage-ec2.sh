#!/bin/bash
set -e

STATE=$(aws ec2 describe-instances --instance-ids $INSTANCE_ID --query "Reservations[0].Instances[0].State.Name" --output text)
echo "Estado actual de la instancia: $STATE"

if [ "$STATE" = "running" ]; then
    echo "Deteniendo la instancia..."
    aws ec2 stop-instances --instance-ids $INSTANCE_ID
    aws ec2 wait instance-stopped --instance-ids $INSTANCE_ID
fi

echo "Iniciando la instancia..."
aws ec2 start-instances --instance-ids $INSTANCE_ID
aws ec2 wait instance-running --instance-ids $INSTANCE_ID