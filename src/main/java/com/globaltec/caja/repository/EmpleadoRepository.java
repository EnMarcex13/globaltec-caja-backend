package com.globaltec.caja.repository;

import com.globaltec.caja.models.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado,Long> {
}
