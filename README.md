# 🚀 Placement Tracker CI/CD Pipeline

## 📌 Project Overview

The **Placement Tracker Application** is a DevOps-enabled web-based system designed to help students efficiently manage and track their placement preparation, job applications, and progress.

This project integrates a complete **CI/CD pipeline using Jenkins, GitHub, Docker, and Selenium**, enabling automated build, test, and deployment on every code change.

---

## ❗ Problem Statement

Engineering students often struggle to:

* Track job applications across multiple companies
* Maintain structured placement preparation
* Monitor interview progress and status updates
* Organize deadlines and preparation consistency

This leads to:

* Missed opportunities
* Lack of preparation tracking
* Unorganized workflow

---

## 🎯 Objectives

The main objectives of this project are:

* Develop a **Placement Tracker system** to manage applications and preparation
* Implement a **fully automated CI/CD pipeline**
* Enable **continuous integration and testing**
* Automate deployment using **Docker containers**
* Ensure reliability and fast delivery through DevOps practices

---

## ⚙️ DevOps Workflow

This project follows a complete CI/CD lifecycle:

```text id="flow1"
Git Commit → GitHub → Webhook → Jenkins → Maven Build → Selenium Tests → Docker Build → Container Deployment
```

### Key DevOps Features:

* ✔ Continuous Integration (CI)
* ✔ Continuous Testing
* ✔ Continuous Deployment (CD)
* ✔ Infrastructure automation using Docker
* ✔ Event-driven builds using GitHub Webhooks

---

## 🧰 Tech Stack

| Technology         | Purpose                             |
| ------------------ | ----------------------------------- |
| Java + Spring Boot | Backend application                 |
| Maven              | Build automation                    |
| Git & GitHub       | Version control                     |
| Jenkins            | CI/CD automation                    |
| Docker             | Containerization                    |
| Selenium WebDriver | Automated testing                   |
| ngrok              | Webhook tunneling for local Jenkins |
| Windows CMD        | Local execution                     |

---

## 🌿 Branch Strategy

The project uses a structured Git workflow:

* **main** → Production-ready code (Jenkins builds this branch)
* **dev** → Development and integration testing
* **feature-login** → Isolated feature development

```text id="branchflow"
feature branch → dev → main → Jenkins pipeline trigger
```

---

## 🔄 CI/CD Pipeline Stages

The Jenkins pipeline includes the following stages:

1. **Fetch Code**

   * Pulls latest code from GitHub repository

2. **Build Application**

   * Uses Maven to compile and package the Spring Boot application

3. **Start Application**

   * Runs the application in background for testing

4. **Run Selenium Tests**

   * Executes automated UI tests using ChromeDriver

5. **Docker Build**

   * Builds Docker image from application JAR

6. **Stop Old Container**

   * Removes previous running container (if any)

7. **Deploy Container**

   * Runs updated application in Docker container

---

## 🔗 CI/CD Trigger Mechanism

The pipeline is automatically triggered using **GitHub Webhooks**.

### Flow:

```text id="webflow"
Developer Push → GitHub → ngrok → Jenkins → Build Trigger
```

### Webhook URL:

```
https://mutilator-appealing-unsavory.ngrok-free.dev/github-webhook/
```

---

## 🐳 Docker Usage

Docker ensures consistent deployment across environments.

### Build Image:

```bash id="docker1"
docker build -t tracker-image .
```

### Run Container:

```bash id="docker2"
docker run -d -p 7070:8090 tracker-image
```

---

## 🧪 Testing Strategy

* Automated testing using **Selenium WebDriver**
* Tests executed after application startup
* Ensures UI and backend stability

---

## 🚧 Challenges Faced

### 1. Jenkins Not Triggering Builds

* Issue: No new builds after push
* Fix: Ensured new commits and correct webhook setup

### 2. Webhook Configuration Issues

* Issue: Confusion in GitHub webhook delivery
* Fix: Corrected `/github-webhook/` endpoint and verified 200 OK response

### 3. Application Startup Delay

* Issue: Selenium tests failing due to early execution
* Fix: Added delay before test execution

### 4. ngrok URL Change

* Issue: Webhook broke after restart
* Fix: Updated GitHub webhook with new ngrok URL

---

## 🧠 Key Learnings

* CI/CD is **commit-driven**, not manual
* Webhooks trigger builds, but Jenkins decides execution
* Docker ensures environment consistency
* Selenium requires application readiness before execution
* ngrok enables local-to-cloud integration

---

## 🚀 Future Enhancements

* Kubernetes deployment instead of Docker only
* Cloud deployment (AWS / Azure)
* Role-based dashboard for students
* Email notifications for application updates

---

## 📌 Conclusion

This project successfully demonstrates a complete **DevOps CI/CD pipeline** integrating GitHub, Jenkins, Selenium, and Docker. It automates the entire software delivery lifecycle from code commit to deployment, reflecting real-world industry practices.

---

## 👨‍💻 Development Branch

The `dev` branch is used for:

* Feature testing
* Integration validation
* Pre-production verification

Only stable code is merged into `main` for Jenkins builds.


Just tell me 👍
