1. IAM overview
    1. IAM User   - IAM Policy
    2. IAM Group  - IAM Policy
    3. IAM Policy - IAM Policy - Used by services like EC2 that will allow it to access other services
2. Authentication Methods
    1. Access Key - Access Key ID & Secret Access Key - Programmatic access to API
    2. IAM User - Password - AWS Management Console
    3. Server Signing Certificate
3. VPC - Logically isolated portion of AWS cloud within a region
   1. Subnets were created with in Availability Zones and each VPC may contain multiple subnets
   2. VPC router to send info between subnets
   3. Main route table is used to route traffic
      1. 0.0.0.0/0 will route traffic to internet gateway
      2. 172.31.0.0/16 will route traffic internally
   4. Public vs Private subnet - Instances in public subnet will get public addresses using which they can communicate using internet gateway
   5. Each VPC has a separate set of addresses
   6. CIDR. Each subnet will get subset of ip addresses from VPC - Classless Interdomain Routing
   7. Public Subnet will have auto-assign public ipv4 address set to true by default
   8. Internet gateway is associated with an VPC
4. Security Groups And Network ACL
   1. Security Group will be at instance level(s) - Contains allow rules - All rules were evaluated - Explicit association is required
   2. Network ACL will be at subnet level - Contains allow & deny rules - Rules were evaluated in order - Automatically applies to everything running in your subnet
   3. Security group will be responsible for routing/restricting traffic between instances(organized by security groups) in a subnet level
   4. Network ACL
   5. Security Groups will be within VPC, so we need security groups for each VPC
   6. Security Group will deny all traffic by default outside it
   7. Security Group will allow all traffic by default within it
   8. Stateful firewall - If it allows inbound on a port, it will automatically allow outbound from the same port
   9. Stateless firewall - Need rules for both inbound & outbound traffic
   1. Security Group - Stateful Firewall
   2. Network ACL - Stateless Firewall
5. Public And Private Services
   1. Public - S3, DynamoDB, Route 53, CloudFront
6. Elastic Compute Cloud(EC2)
   1. EC2 Instance can contain three types of IP addresses
      1. Public - Public Subnet, lost during restarts; Can't be moved between instances
      2. Private - Retained during restarts, irrespective of public or private subnet each ec2 will have one private ip address
      3. Elastic - Static public address, retained during restarts; Chargeable if not used; Can be moved between instances and elastic network adapters
   2. NAT Gateway - Network Address Translation
   3. Key Pair to access instance - Public & Private Key
      1. 
7. AMI - Amazon Machine Images
8. EBS - Elastic Block Store
9. 
   
