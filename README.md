<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  

<body>

<header>
  <h1>BloodConnect Ops App</h1>
  <p>Internal Operations Platform for Blood Donation Management</p>
</header>

<main>

  <section>
    <h2>Overview</h2>
    <p>
      BloodConnect Ops App is an internal mobile application designed to
      streamline operational workflows for blood donation management.
      It replaces fragmented tools such as spreadsheets and messaging apps
      with a unified, reliable system.
    </p>
  </section>

  <section>
    <h2>Key Features</h2>
    <ul>
      <li>Role-based authentication and access control</li>
      <li>Blood request creation and lifecycle tracking</li>
      <li>Volunteer and donor management</li>
      <li>Event and outreach coordination</li>
      <li>Offline-first data handling using Room</li>
      <li>Local notifications for urgent requests</li>
    </ul>
  </section>

  <section>
    <h2>Architecture</h2>
    <p>
      The application follows Clean Architecture principles with MVVM,
      ensuring scalability, maintainability, and testability.
    </p>

    <pre>
UI (Jetpack Compose)
   ↓
ViewModel
   ↓
Use Cases (Domain Layer)
   ↓
Repository Interfaces
   ↓
Repository Implementations
   ↓
Room Database / API
    </pre>
  </section>

  <section>
    <h2>Project Structure</h2>
    <pre>
com.bloodconnect.ops
├── data
│   ├── local
│   ├── mapper
│   └── repository
├── domain
│   ├── model
│   ├── repository
│   └── usecase
├── ui
│   ├── auth
│   ├── dashboard
│   ├── helpline
│   ├── volunteer
│   ├── donor
│   ├── event
│   └── components
├── navigation
└── viewmodel
    </pre>
  </section>

  <section>
    <h2>Technology Stack</h2>
    <div class="tech-stack">
      <span>Kotlin</span>
      <span>Jetpack Compose</span>
      <span>MVVM</span>
      <span>Clean Architecture</span>
      <span>Room Database</span>
      <span>Kotlin Coroutines</span>
      <span>WorkManager</span>
      <span>Android Notifications</span>
    </div>
  </section>

  <section>
    <h2>Offline-First Strategy</h2>
    <ul>
      <li>Room acts as the single source of truth</li>
      <li>Local persistence before network synchronization</li>
      <li>Background sync via WorkManager</li>
      <li>Audit-friendly data lifecycle</li>
    </ul>
  </section>

  <section>
    <h2>Future Enhancements</h2>
    <ul>
      <li>Cloud-based authentication and synchronization</li>
      <li>Push notifications</li>
      <li>Advanced analytics and reporting</li>
      <li>Admin approval workflows</li>
    </ul>
  </section>

</main>

<footer>
  <p><strong>Krishna Agrawal</strong></p>
  <p>Android Developer | Kotlin | Jetpack Compose</p>
</footer>

</body>
</html>
