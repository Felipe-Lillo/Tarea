package testClases.ChileAutosClass;

import page.ChileAutos.*;

import java.io.IOException;

public class RecuperarDatosVehiculos {
    public void descargarArchivos() throws InterruptedException, IOException {
        Index index = new Index();
        index.clickearBotonBusqueda();
        Vehiculos vehiculos = new Vehiculos();
        vehiculos.datosVehiculos();
        InformaciónVehiculoSeleccionado informaciónVehiculoSeleccionado = new InformaciónVehiculoSeleccionado();
        informaciónVehiculoSeleccionado.extraerInformacion();

    }
}
