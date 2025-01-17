<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
  <meta charset="utf-8"/>
  <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
  <meta
          name="viewport"
          content="width=device-width, initial-scale=1, shrink-to-fit=no"
  />
  <meta name="description" content=""/>
  <meta name="author" content=""/>

  <title>Zarezerwuj kajak</title>

  <!-- Custom fonts for this template-->
  <link
          href="<c:url value="/theme/vendor/fontawesome-free/css/all.css"/>"
          rel="stylesheet"
          type="text/css"
  />
  <link
          href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
          rel="stylesheet"
  />

  <!-- Custom styles for this template-->
  <link href="<c:url value="/theme/css/sb-admin-2.css"/>" rel="stylesheet"/>
  <style>
    .bg-gradient-orange {
      background: linear-gradient(180deg, #f86e1b, #fc934e);
    }
  </style>
</head>

<body id="page-top">
<!--
Page
Wrapper -->
<div id="wrapper">
  <!-- Sidebar -->
  <ul
          class="navbar-nav bg-gradient-orange sidebar sidebar-dark accordion"
          id="accordionSidebar"
  >
    <!-- Sidebar - Brand -->
    <a
            class="sidebar-brand d-flex align-items-center justify-content-center"
            href="/userList"
    >
      <div class="sidebar-brand-icon rotate-n-15">
        <i class="fas fa-anchor"></i>
      </div>
      <div class="sidebar-brand-text mx-3">Adrena<sup>lina</sup></div>
    </a>

    <!-- Divider -->
    <hr class="sidebar-divider my-0"/>

    <!-- Nav Item - Dashboard -->
    <li class="nav-item active">
      <a class="nav-link" href="/user/list">
        <i class="fas fa-fw fa-tachometer-alt"></i>
        <span>Dashboard</span></a
      >
    </li>

    <!-- Sidebar Toggler (Sidebar) -->
    <div class="text-center d-none d-md-inline">
      <button class="rounded-circle border-0" id="sidebarToggle"></button>
    </div>
  </ul>
  <!-- End of Sidebar -->

  <!-- Content Wrapper -->
  <div id="content-wrapper" class="d-flex flex-column">
    <!-- Main Content -->
    <div id="content">
      <!-- Topbar -->
      <nav
              class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow"
      ></nav>
      <!-- End of Topbar -->
