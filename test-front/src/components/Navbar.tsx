import { useNavigate } from "react-router";

import { useAuthStore } from "../hooks/useAuthStore";

export function Navbar() {
    const { startLogout } = useAuthStore();
    const navigate = useNavigate();

    const handleLogout = () => {
        startLogout();
        navigate("/login");
    };

    return (
        <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
            <div className="container-fluid">
                <a className="navbar-brand" href="#">Home</a>
                <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>
                <div className="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                        <li className="nav-item">
                            <button className="nav-link" onClick={handleLogout}>Cerrar sesión</button>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    );
}