import { Button, Modal } from "react-bootstrap";
import { Formik } from "formik";

import { useAppDispatch } from "../../hooks/hooks";
import type { AppDispatch } from "../../store/store";
import { getApiUsers, postApiUserCreate } from "../../store/slices/users/usersThunks";
import "./ModalUser.css";

interface PropsModalUser {
  onClickModalUser: any;
}

export function ModalOrder({ onClickModalUser }: PropsModalUser) {
  const dispatch: AppDispatch = useAppDispatch();

  return (
    <Modal show={true} backdrop="static" keyboard={false}>
      <Formik
        initialValues={{
          name: "",
          firstName: "",
          lastName: "",
          email: "",
          age: 0,
          password: "",
        }}
        onSubmit={async (values, { setSubmitting }) => {
          await dispatch(postApiUserCreate({
            ...values,
          }));
          dispatch(getApiUsers());
          onClickModalUser();
          setSubmitting(false);
        }}
      >
        {({ values, isSubmitting, handleChange, handleSubmit }) => (
          <form onSubmit={handleSubmit}>
            <Modal.Header>
              <Modal.Title>Agregar nuevo usuario</Modal.Title>
            </Modal.Header>
            <Modal.Body>
              <div className="row mb-2">
                <div className="col-6">
                  <label className="form-label">
                    Nombre <span>*</span>
                  </label>
                  <input
                    type="text"
                    className="form-control"
                    name="name"
                    id="name"
                    placeholder="Andres"
                    value={values.name}
                    onChange={handleChange}
                    required
                  />
                </div>
                <div className="col-6">
                  <label className="form-label">
                    Primer apellido <span>*</span>
                  </label>
                  <input
                    type="text"
                    className="form-control"
                    name="firstName"
                    id="firstName"
                    placeholder="Farias"
                    value={values.firstName}
                    onChange={handleChange}
                    required
                  />
                </div>
              </div>
              <div className="row mb-2">
                <div className="col-6">
                  <label className="form-label">
                    Segundo apellido <span>*</span>
                  </label>
                  <input
                    type="text"
                    className="form-control"
                    name="lastName"
                    id="lastName"
                    placeholder="Bautista"
                    value={values.lastName}
                    onChange={handleChange}
                  />
                </div>
                <div className="col-6">
                  <label className="form-label">
                    Edad <span>*</span>
                  </label>
                  <input
                    type="number"
                    className="form-control"
                    name="age"
                    id="age"
                    placeholder=""
                    value={values.age}
                    onChange={handleChange}
                    required
                  />
                </div>
              </div>
              <div className="row mb-2">
                <div className="col-6">
                  <label className="form-label">
                    Correo <span>*</span>
                  </label>
                  <input
                    type="email"
                    className="form-control"
                    name="email"
                    id="email"
                    placeholder="name@example.com"
                    value={values.email}
                    onChange={handleChange}
                    required
                  />
                </div>
                <div className="col-6">
                  <label className="form-label">
                    Password <span>*</span>
                  </label>
                  <input
                    type="password"
                    className="form-control"
                    name="password"
                    id="password"
                    placeholder=""
                    value={values.password}
                    onChange={handleChange}
                    required
                  />
                </div>
              </div>
            </Modal.Body>
            <Modal.Footer>
              <Button variant="secondary" onClick={onClickModalUser}>
                Cancelar
              </Button>
              <Button variant="primary" type="submit" disabled={isSubmitting}>Guardar</Button>
            </Modal.Footer>
          </form>
        )}
      </Formik>
    </Modal>
  );
}
