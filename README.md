# Library Management System

## Overview
A Java console application implementing a Library Management System with core features including book management, patron management, lending, and reservation. The system follows OOP design, SOLID principles, and uses Factory and Observer design patterns.

## Features
- Add, remove, update books and patrons
- Search books by title, author, and ISBN
- Checkout and return books
- Book reservation and notification system

## Design
The system uses the following design patterns:
- Factory Pattern: `BookFactory` for creating book objects.
- Observer Pattern: `ReservationManager` notifies patrons when reserved books become available.

