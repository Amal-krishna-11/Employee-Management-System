# Employee Management System - Project Documentation

## Project Title
Employee Management System using Tree and HashMap in Java

## Introduction

This project is a console-based Employee Management System developed using Java.
It models a company's reporting hierarchy using a Tree Data Structure and provides
fast employee searching using HashMap.

## Problem Statement

Design a system to represent employee-manager relationships in an organization
and perform employee operations efficiently using Data Structures.

## Objectives

- Represent company hierarchy using Tree
- Search employees using HashMap
- Implement CRUD operations
- Apply Object-Oriented Programming concepts
- Understand Low-Level Design principles

## System Design

The system contains:

1. Employee Node
2. Company Hierarchy Tree
3. Employee HashMap

## Data Structures Used

### Tree

Used to represent the reporting relationship.

Example:

CEO
 |
 Manager
 |
 Developer


### HashMap

Employee ID is used as the key to quickly access employee details.

Average search complexity: O(1)

## Operations

## Operations

The system provides the following operations:

1. **Add Employee**
   - Adds a new employee and connects them with their respective manager.

2. **Search Employee**
   - Searches employee details using Employee ID through HashMap.

3. **Display Company Hierarchy**
   - Displays the complete organization structure using Tree traversal.

4. **Count Employees**
   - Calculates the total number of employees in the organization.

5. **Update Employee**
   - Updates employee name and designation.

6. **Delete Employee**
   - Removes an employee from the organization.

7. **Display Employees Under Manager**
   - Displays all employees reporting to a particular manager.

8. **Display Reporting Chain**
   - Displays the path of an employee from their manager up to the CEO.

9. **Exit**
   - Closes the application.

## Conclusion

The project demonstrates the practical implementation of Tree and HashMap
data structures along with Object-Oriented Programming concepts.
It provides an efficient solution for managing employee records, maintaining
organizational hierarchy, and performing CRUD operations using Low-Level Design
principles.