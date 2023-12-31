import "bootstrap/dist/css/bootstrap.min.css";
import { Link, NavLink, Outlet } from "react-router-dom";
import { AppContext } from "./contexts/AppContext";
import { useState } from "react";

function App() {
  const [users, setUsers] = useState([]);

  return (
    <>
      <header>
        <nav
          className="navbar navbar-expand-lg bg-body-tertiary"
          data-bs-theme="dark"
        >
          <div className="container-fluid">
            <Link className="navbar-brand" href="#">
              eWebsite
            </Link>
            <button
              className="navbar-toggler"
              type="button"
              data-bs-toggle="collapse"
              data-bs-target="#navbarNav"
              aria-controls="navbarNav"
              aria-expanded="false"
              aria-label="Toggle navigation"
            >
              <span className="navbar-toggler-icon"></span>
            </button>
            <div className="collapse navbar-collapse" id="navbarNav">
              <ul className="navbar-nav">
                <li className="nav-item">
                  <NavLink className="nav-link" to={`/`}>
                    Accueil
                  </NavLink>
                </li>
                <li className="nav-item">
                  <NavLink className="nav-link" to={`/contacts`}>
                    Contacts
                  </NavLink>
                </li>
              </ul>
            </div>
          </div>
        </nav>
      </header>
      <main className="container">
        <div className="row my-3">
          <div className="col-10 offset-1 rounded p-3 bg-dark text-light">
            <AppContext.Provider value={{ users: users, setUsers: setUsers }}>
              <Outlet />
            </AppContext.Provider>
          </div>
        </div>
      </main>
    </>
  );
}

export default App;
