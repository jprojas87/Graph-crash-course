package graph;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE ESTACIONES TRANSMILENIO ===\n");

        // Crear un grafo dirigido y ponderado (weighted + directed)
        Graph transmilenio = new Graph(true, true);

        System.out.println("1. CREANDO VÉRTICES (Estaciones)...\n");

        // Línea Troncal Caracas (roja)
        Vertex portal80 = transmilenio.addVertex("Portal 80");
        Vertex flores = transmilenio.addVertex("Flores");
        Vertex mazuren = transmilenio.addVertex("Mazurén");
        Vertex heroes = transmilenio.addVertex("Héroes");
        Vertex calle76 = transmilenio.addVertex("Calle 76");

        // Línea Troncal NQS (verde) - conecta con Héroes
        Vertex suba = transmilenio.addVertex("Suba Calle 95");
        Vertex pepe = transmilenio.addVertex("Pepe Sierra");

        // Línea Troncal Américas (amarilla) - conecta con Héroes
        Vertex banderas = transmilenio.addVertex("Banderas");
        Vertex ricaurte = transmilenio.addVertex("Ricaurte");

        System.out.println("Total de estaciones creadas: " + transmilenio.getVertices().size() + "\n");

        System.out.println("2. CREANDO ARISTAS (Conexiones entre estaciones)...\n");
        System.out.println("   Formato: Origen --> Destino (tiempo en segundos)\n");

        // Línea Caracas (Portal 80 → Calle 76)
        transmilenio.addEdge(portal80, flores, 180);      // 3 minutos
        transmilenio.addEdge(flores, mazuren, 150);       // 2.5 minutos
        transmilenio.addEdge(mazuren, heroes, 200);       // 3.3 minutos
        transmilenio.addEdge(heroes, calle76, 120);       // 2 minutos

        // Línea NQS (Suba → Héroes)
        transmilenio.addEdge(suba, pepe, 240);           // 4 minutos
        transmilenio.addEdge(pepe, heroes, 300);         // 5 minutos

        // Línea Américas (Banderas → Héroes)
        transmilenio.addEdge(banderas, ricaurte, 140);   // 2.3 minutos
        transmilenio.addEdge(ricaurte, heroes, 220);     // 3.6 minutos

        // Conexión de retorno desde Héroes (para demostrar grafo dirigido)
        transmilenio.addEdge(heroes, banderas, 250);     // 4.2 minutos

        System.out.println("3. IMPRIMIENDO EL GRAFO COMPLETO:\n");
        transmilenio.print();

        System.out.println("\n4. DEMOSTRANDO OPERACIONES DEL GRAFO:\n");

        // Buscar una estación específica
        Vertex estacionBuscada = transmilenio.getVertexByValue("Héroes");
        if (estacionBuscada != null) {
            System.out.println("Estación encontrada: " + estacionBuscada.getData());
            System.out.println("Conexiones desde Héroes:");
            estacionBuscada.print(true);
        }

        System.out.println("\n5. ANÁLISIS DE CONECTIVIDAD:\n");

        // Mostrar estaciones con más conexiones salientes
        System.out.println("Estaciones y número de conexiones salientes:");
        for (Vertex v : transmilenio.getVertices()) {
            System.out.println("  " + v.getData() + ": " + v.getEdges().size() + " conexión(es)");
        }

        System.out.println("\n6. SIMULANDO ELIMINACIÓN DE UNA CONEXIÓN:\n");

        // Eliminar una arista (simular cierre temporal)
        System.out.println("Cerrando temporalmente: Mazurén --> Héroes");
        transmilenio.removeEdge(mazuren, heroes);

        System.out.println("\nGrafo después de eliminar la conexión:");
        mazuren.print(true);

        System.out.println("\n7. RESTAURANDO LA CONEXIÓN:\n");
        transmilenio.addEdge(mazuren, heroes, 200);
        mazuren.print(true);

        System.out.println("\n8. CARACTERÍSTICAS DEL GRAFO:\n");
        System.out.println("  ¿Es dirigido? " + (transmilenio.isDirected() ? "Sí" : "No"));
        System.out.println("  ¿Es ponderado? " + (transmilenio.isWeighted() ? "Sí" : "No"));
        System.out.println("  Total de vértices: " + transmilenio.getVertices().size());

        // Contar aristas totales
        int totalAristas = 0;
        for (Vertex v : transmilenio.getVertices()) {
            totalAristas += v.getEdges().size();
        }
        System.out.println("  Total de aristas: " + totalAristas);

        System.out.println("\n=== FIN DE LA DEMOSTRACIÓN ===");


    }
}
