# Rewards API

A simple Spring Boot REST API that calculates reward points for customers based on transaction amounts over a three month period.

## Overview

This application demonstrates a rewards program where:

- Customers earn **1 point for every dollar spent between $50 and $100**
- Customers earn **2 points for every dollar spent above $100**
- Transactions of **$50 and below earn 0 points**

The application uses **in-memory transaction data** to keep the project simple and easy to run.

## Tech Stack

- Java 17
- Spring Boot
- Spring Web
- JUnit 5
- Maven

## Project Structure

```text
src
└── main
    └── java
        └── com.example.rewards
            ├── controller
            ├── dto
            ├── model
            ├── repository
            └── service
