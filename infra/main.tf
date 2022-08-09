terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 4.16"
    }
  }

  required_version = ">= 1.2.0"
}

provider "aws" {
  profile = "default"
  region  = "ap-northeast-2"
}

resource "aws_instance" "dev_app_server" {
  ami                    = "ami-0ea5eb4b05645aa8a"
  instance_type          = "t2.micro"
  key_name               = "gurumi-key"
  vpc_security_group_ids = [aws_security_group.dev_nginx_security_group.id]

  tags = {
    Name = "DevAppServer"
  }
}

resource "aws_instance" "dev_nginx_server" {
  ami                    = "ami-0ea5eb4b05645aa8a"
  instance_type          = "t2.micro"
  key_name               = "gurumi-key"
  vpc_security_group_ids = [aws_security_group.dev_nginx_security_group.id]

  tags = {
    Name = "DevNginxServer"
  }
}

resource "aws_security_group" "dev_nginx_security_group" {
  egress = [
    {
      cidr_blocks      = ["0.0.0.0/0", ]
      description      = ""
      from_port        = 0
      ipv6_cidr_blocks = []
      prefix_list_ids  = []
      protocol         = "-1"
      security_groups  = []
      self             = false
      to_port          = 0
    }
  ]

  ingress = [
    {
      cidr_blocks      = ["0.0.0.0/0", ]
      description      = ""
      from_port        = 22
      ipv6_cidr_blocks = []
      prefix_list_ids  = []
      protocol         = "tcp"
      security_groups  = []
      self             = false
      to_port          = 22
    }
  ]
}
