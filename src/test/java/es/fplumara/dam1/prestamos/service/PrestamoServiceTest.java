package es.fplumara.dam1.prestamos.service;


import es.fplumara.dam1.prestamos.repository.MaterialRepositoryImpl;
import es.fplumara.dam1.prestamos.repository.PrestamoRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
class PrestamosServiceTest {
    @Mock
    private PrestamoRepositoryImpl prestamoRepository;
@Mock
    private MaterialRepositoryImpl materialRepository;
@InjectMocks
private PrestamoServiceImpl prestamoService;
@Test
    void crearPrestamo_ok_cambiaEstado_y_guarda(){

}
    // TODO (alumnos): añadir JUnit 5 y Mockito en el pom.xml y completar:
    //
    // - crearPrestamo_ok_cambiaEstado_y_guarda()
    // - crearPrestamo_materialNoExiste_lanzaNoEncontrado()
    // - crearPrestamo_materialNoDisponible_lanzaMaterialNoDisponible()
    // - devolverMaterial_ok_cambiaADisponible()
    //
    // Requisito: usar mocks de repositorios y verify(...)
}
