package GestionServicios;

import java.util.UUID;

public class ServicioTecnico implements IServicioTecnico
{
        @Override
        public void solicitarServicioTecnico() {
        // Generar un número de ticket único
        String numeroTicket = UUID.randomUUID().toString();

        // Imprimir el ticket
        System.out.println("Ticket de servicio técnico");
        System.out.println("Número de ticket: " + numeroTicket);
        System.out.println("------------------------------");

        // Simular la resolución de un problema
        System.out.println("Resolviendo el inconveniente...");
        // Lógica adicional para resolver el problema
        try {
            Thread.sleep(2000); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Mensaje de servicio realizado con éxito
        System.out.println("Servicio realizado con éxito.");
    }
}
