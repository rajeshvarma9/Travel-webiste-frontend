import React from "react";
import { Nav } from "react-bootstrap";
import Container from "react-bootstrap/Container";
import Navbar from "react-bootstrap/Navbar";
import "bootstrap/dist/css/bootstrap.min.css";

export default function NavigationHome() {

  return (
    <div>
      
      <Navbar collapseOnSelect expand="lg" bg="primary" variant="dark">
        <Container>
          <Navbar.Brand href="#home">Travel-Easy</Navbar.Brand>
          <Navbar.Toggle aria-controls="responsive-navbar-nav" />
          <Navbar.Collapse id="responsive-navbar-nav">
                <Nav>
                  <Nav.Link href="/loginuser">Login</Nav.Link>
                  <Nav.Link href="/register">Register</Nav.Link>
                </Nav>
          </Navbar.Collapse>
        </Container>
      </Navbar>
    </div>
  );
}
