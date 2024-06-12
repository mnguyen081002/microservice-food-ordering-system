# Microservice Food Ordering System

### Features
- Using Outbox, Orchestration-based saga pattern to maintain data consistency across multiple services without using distributed transactions.
- Using API Gateway for Authorization and Authentication.

### Architecture
![image](https://github.com/mnguyen081002/microservice-food-ordering-system/assets/76799726/e4692eb2-e0bf-4478-9e78-ab284f12ba4c)

### Outbox, Sage pattern diagram
![image](https://github.com/mnguyen081002/microservice-food-ordering-system/assets/76799726/1b3d495c-c6d8-4923-b049-8eafa1f2393f)

### Sequence diagram (Happy case)
![image](https://github.com/mnguyen081002/microservice-food-ordering-system/assets/76799726/1f513745-44bc-4ea9-a9a4-9f41523afd8d)

### Sequence diagram (Unhappy case: payment failed)
![image](https://github.com/mnguyen081002/microservice-food-ordering-system/assets/76799726/341ea1b2-decd-47b9-b69b-4d034e89f5af)

### Sequence diagram (Unhappy case: order approval failed)
![image](https://github.com/mnguyen081002/microservice-food-ordering-system/assets/76799726/ce401c85-1da1-4172-ae9c-87a0bd0c224b)
