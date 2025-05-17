# EmailGenerator

## Overview
> Last updated: 9 May 2025

This repository is structured as a **monorepo** and includes the following components:

- `client/`: Angular frontend application
- `server/`: Spring Boot (Maven) backend
- `e2e/`: Playwright-based end-to-end tests
- Supporting files for Docker and GitHub Actions workflows

---

## Installation

After cloning the repository, ensure you have these downloaded:
java 17, docker, nvm, node
open a terminal in the root directory and run:

```bash
npm run setup         # Recommended: for users using nvm (Node Version Manager)
(or use) sudo npm run setup    # If your npm setup requires elevated permissions
cd client
sudo apt install ng-common
npm install -g @angular/cli
```

This script will install all required dependencies in the root, `client/`, and `e2e/` directories.

---

## Running the Application

### Backend: Spring Boot (Maven)

Navigate to the `server/` directory and run:

```bash
./mvnw clean (cleans)
./mvnw spring-boot:run (runs)
./mvnw test (runs unit testing)
```

- The backend service will be available at: `http://localhost:8080`

---

### Frontend: Angular

Navigate to the `client/` directory and run:

```bash
ng serve
ng test or npm run test (for testing)
```

- The Angular app will be served at: `http://localhost:4200`

---

### Database: PostgreSQL via Docker

From the root directory, run:

```bash
docker-compose down
docker-compose up -d
```

- The PostgreSQL container will be launched.
- pgAdmin is available at: `http://localhost:5050`
- Login credentials are stored in the `.env` file.

---

## Branching Strategy

### Development Workflow

1. Pull the latest changes from the `develop` branch:

   ```bash
   git pull -r
   ```

2. Create a new feature branch:

   ```bash
   git checkout -b feature/yourFeatureName
   ```

   Replace `yourFeatureName` with a clear, relevant name based on your work.

3. When your feature is complete and all unit tests pass:
   push the branch via ``` git push origin feature/yourFeatureName ```
   
4. Go to github and open a pull request targeting `develop`.

---

### Testing Workflow

1. Pull the latest code from the `develop` branch.
2. Create a new branch from `develop`.
3. Complete your testing.
4. Once testing is complete, push your branch and open a pull request targeting `main`.

---

## Pushing Code & CI Requirements

Branch protection is enforced via GitHub Actions workflows.

### Merging to `develop`:
- All **unit tests** (for both server and client) must pass.

### Merging to `main`:
- All **unit tests** (server and client) must pass.
- All **end-to-end (e2e) tests** must pass as well.

### Additional Rules:
- A **pull request** is required for all merges.
- Each PR must be reviewed and approved by at least **one team member**.

