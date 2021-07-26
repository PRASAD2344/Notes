1. Open source container orchestration tool
2. Feature:
    1. High availability
    2. Scalability or high performance
    3. Disaster recovery - backup and restore
3. K8s Components
    1. Container
    2. Pod - Abstract layer over container
    3. Service - Permanent IP Address
        1. External Service
        2. Internal Service
    4. Ingress - Will in-turn call service(ip-address)
    5. ConfigMap - External configuration of your application
        1. Don't put plain username & password in config map. Use secret instead
    6. Secret - Used to store secret data and is base64 encoded
        1. Built-in security mechanism not enabled by default
    7. Volumes - K8s doesn't manage data persistence, so we are responsible for back-up, replication, and maintenance
    8. Deployment - Blueprint for pods, and can be viewed as abstract layer over pods
        1. Database can't be replicated via Deployment, because it contains state
    9. StatefulSet - For stateFul Apps or databases
        1. Difficult to do so in K8s
        2. DB were often hosted outside K8s cluster
4. K8s Architecture
    1. Worker machine in K8s cluster
        1. Each node can have multiple Pods on it
        2. 3 processes must be installed on every node
            1. Container runtime like Docker
            2. Kubelet - Process that interacts with both the container and node; Starts the pod with a container inside
            3. Kube Proxy
    2. Master nodes - Less resources as it will have less workload. CPU|RAM|STORAGE
        1. API Server
           1. Cluster gateway
           2. Acts as a gatekeeper for authentication
        2. Scheduler
           1. Schedule a new pod
           2. Where to put the new pod
           3. Kubelet is responsible for creating a new pod
        3. Controller Manager
           1. Detect cluster state changes
           2. Will call scheduler to schedule a new pod whenever a pod dies
        4. etcd
           1. Cluster brain
           2. Cluster changes get stored in key-value store
    3. In every K8s cluster we have multiple master nodes
        1. etcd - Distributed storage
5. Minikube & Kubectl
    1. Minikube
        1. Master & Node processes run on one machine - Test/Local Cluster Setup - Open Source
        2. Docker container pre-installed
        3. Creates virtual box on your laptop
        4. Node runs in that virtual box
        5. 1 Node K8s cluster
    2. Kubectl
        1. Command line tool for K8s cluster
        2. Will talk to API Server in Master Processes
    3. ```minikube start --vm-drive=hyperkit```
6. kubectl commands
    1. 
