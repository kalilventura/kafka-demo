import random
import time

from kafka import KafkaProducer

# Create an instance of the Kafka producer
producer = KafkaProducer(bootstrap_servers='localhost:9092', value_serializer=lambda v: str(v).encode('utf-8'))

# Call the producer.send method with a producer-record
topic = 'users'
print(f"Enviando dados para o tópico: {topic}")
while True:
    age = random.randint(1, 90)
    name = 'Robert'
    message = f'User - name: {name} | age: {age} created =)'
    print(f'Send {message}')

    producer.send(topic, message, b'user')
    time.sleep(10)
