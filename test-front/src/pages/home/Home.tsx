import { Button, Card, CardBody, CardTitle } from "react-bootstrap";
import { useEffect, useState } from "react";

import { AppTable } from "../../components/table/AppTable";
import "./Home.css";
import { useAppDispatch, useAppSelector } from "../../hooks/hooks";
import type { AppDispatch } from "../../store/store";
import { ModalOrder } from "../../components/modalUser/ModalUser";
import { getApiUsers } from "../../store/slices/users/usersThunks";

const columns = [
    "Id",
    "Nombre",
    "Primer Apellido",
    "Segundo Apellido",
    "Correo",
    "Edad"
];

export function Home() {
    const dispatch: AppDispatch = useAppDispatch();
    const { usersList } = useAppSelector(
        state => state.userState,
    );
    const [show, setShow] = useState(false);

    useEffect(() => {
        dispatch(getApiUsers());
    }, []);

    const handleClick = () => {
        setShow(!show);
    };

    const handleShowModal = () => {
        setShow(!show);
    };

    return (
        <div className="" >
            <div className="mt-4 mb-4">
                <h2>Administración de Usuarios</h2>
            </div>
            <div className="container">
                <Card bg="light">
                    <CardBody>
                        <CardTitle>Lista de usuarios</CardTitle>
                        <AppTable columns={columns} usersList={usersList} />
                    </CardBody>
                     <Card.Body>
                        <Card.Link>
                            <Button onClick={handleClick} variant="primary">Nuevo usuario</Button>
                        </Card.Link>
                    </Card.Body>
                </Card>
            </div>
            {show ? <ModalOrder onClickModalUser={handleShowModal} /> : ""}
        </div>
    );
}