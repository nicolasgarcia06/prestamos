package es.fplumara.dam1.prestamos.service;

import es.fplumara.dam1.prestamos.model.EstadoMaterial;
import es.fplumara.dam1.prestamos.model.Material;
import es.fplumara.dam1.prestamos.model.Prestamo;
import es.fplumara.dam1.prestamos.repository.Repository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PrestamoServiceTest {

    @Mock
    private Repository<Material> materialRepository;

    @Mock
    private Repository<Prestamo> prestamoRepository;

    @InjectMocks
    private PrestamoService service; // usa tu implementación real

    @Test
    void crearPrestamo_ok_cambiaEstado_y_guarda() {
        // Arrange
        String idMaterial = "MAT-001";
        String profesor = "Ana Pérez";
        LocalDate fecha = LocalDate.of(2026, 2, 16);

        Material material = new Material();
        material.setId(idMaterial);
        material.setEstado(EstadoMaterial.DISPONIBLE);

        when(materialRepository.findById(idMaterial)).thenReturn(Optional.of(material));

        // Capturadores para verificar lo que se guarda
        ArgumentCaptor<Prestamo> prestamoCaptor = ArgumentCaptor.forClass(Prestamo.class);
        ArgumentCaptor<Material> materialCaptor = ArgumentCaptor.forClass(Material.class);

        // Act
        Prestamo creado = service.crearPrestamo(idMaterial, profesor, fecha);

        // Assert
        // 1) Se devolvió un préstamo con datos correctos
        assertNotNull(creado, "El préstamo creado no debe ser null");
        assertNotNull(creado.getId(), "El id del préstamo debe generarse (UUID u otro)");
        assertEquals(idMaterial, creado.getIdMaterial(), "El préstamo debe referenciar el id del material");
        assertEquals(profesor, creado.getProfesor(), "El profesor debe coincidir");
        assertEquals(fecha, creado.getFecha(), "La fecha debe coincidir");

        // 2) Se guardó el préstamo con los mismos datos
        verify(prestamoRepository, times(1)).save(prestamoCaptor.capture());
        Prestamo prestamoGuardado = prestamoCaptor.getValue();
        assertNotNull(prestamoGuardado.getId(), "El préstamo guardado debe tener id");
        assertEquals(idMaterial, prestamoGuardado.getIdMaterial(), "Se debe guardar el idMaterial correcto");
        assertEquals(profesor, prestamoGuardado.getProfesor(), "Se debe guardar el profesor correcto");
        assertEquals(fecha, prestamoGuardado.getFecha(), "Se debe guardar la fecha correcta");

        // 3) El material pasó a PRESTADO y se guardó
        verify(materialRepository, times(1)).save(materialCaptor.capture());
        Material materialGuardado = materialCaptor.getValue();
        assertEquals(EstadoMaterial.PRESTADO, materialGuardado.getEstado(),
                "El material debe cambiar a estado PRESTADO");

        // 4) No hay llamadas inesperadas
        verify(materialRepository, times(1)).findById(idMaterial);
        verifyNoMoreInteractions(materialRepository, prestamoRepository);
    }
}
