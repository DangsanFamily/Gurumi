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
  ami           = "ami-0ea5eb4b05645aa8a"
  instance_type = "t2.micro"

  tags = {
    Name = "DevAppServer"
  }
}

resource "aws_instance" "dev_nginx_server" {
  ami           = "ami-0ea5eb4b05645aa8a"
  instance_type = "t2.micro"

  tags = {
    Name = "DevNginxServer"
  }
}
