package com.hackathonTeam3.transformaciondigitalmunicipalapi.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;

@Component
public class DatabaseInitializer implements CommandLineRunner{

@Autowired
private EntityManager entityManager;

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        entityManager.createNativeQuery(
"CREATE OR REPLACE VIEW vista_entidades_con_obras AS "+
"SELECT eg.id, eg.nombre, eg.ubicacion, COUNT(og.id) AS numero_obras,GROUP_CONCAT(og.nombre SEPARATOR ',') AS lista_obras, SUM(og.financiacion) as total_inversion " +
"FROM entidades_gubernamentales eg " +
"LEFT JOIN obras_gubernamentales og " +
"ON eg.id=og.entidades_gubernamentales_id "+
"GROUP BY eg.id, eg.nombre "+
"HAVING numero_obras > 0"
        ).executeUpdate();

        entityManager.createNativeQuery(
"CREATE OR REPLACE VIEW vista_entidades_con_servicios AS "+
"SELECT eg.id, eg.nombre, eg.ubicacion, COUNT(sg.id) AS numero_servicios, GROUP_CONCAT(sg.nombre SEPARATOR ',') AS lista_servicios ,SUM(sg.financiacion) as total_inversion "+
"FROM entidades_gubernamentales eg "+
"LEFT JOIN servicios_gubernamentales sg "+
"ON eg.id=sg.entidades_gubernamentales_id "+
"GROUP BY eg.id, eg.nombre "+
"HAVING numero_servicios > 0"

        ).executeUpdate();

entityManager.createNativeQuery(
    "CREATE OR REPLACE VIEW vista_usuarios_con_citas_a_entidades AS "+
    "SELECT ug.id, ug.nombre,ug.edad ,COUNT(cg.id) as numero_citas, GROUP_CONCAT(cg.nombre SEPARATOR ',') as Lista_Citas, GROUP_CONCAT(eg.nombre SEPARATOR ',') as Lista_Entidades "+
"FROM usuarios_gubernamentales ug "+ 
"LEFT JOIN citaciones_gubernamentales cg "+
"ON ug.id=cg.usuarios_gubernamentales_id "+
"LEFT JOIN entidades_gubernamentales eg "+
"ON eg.id = cg.entidades_gubernamentales_id "+
"GROUP By ug.id, ug.nombre "+
"HAVING  numero_citas > 0"
).executeUpdate();


entityManager.createNativeQuery(
"CREATE OR REPLACE VIEW vista_usuarios_con_incidentes_a_entidades AS "+
"SELECT ug.id, ug.nombre,ug.edad ,COUNT(ig.id) as numero_Incidentes, GROUP_CONCAT(ig.nombre SEPARATOR ',') as Lista_Incidentes, GROUP_CONCAT(eg.nombre SEPARATOR ',') as Lista_Entidades "+
"FROM usuarios_gubernamentales ug "+
"LEFT JOIN incidentes_gubernamentales ig "+
"ON ug.id=ig.usuarios_gubernamentales_id "+
"LEFT JOIN entidades_gubernamentales eg "+
"ON eg.id = ig.entidades_gubernamentales_id "+
"GROUP By ug.id, ug.nombre "+
"HAVING  numero_Incidentes > 0"
).executeUpdate();


entityManager.createNativeQuery(
    "CREATE OR REPLACE VIEW vista_usuario_con_tramites_a_entidades AS "+
"SELECT ug.id, ug.nombre,ug.edad ,COUNT(tg.id) as numero_Tramites, GROUP_CONCAT(tg.nombre SEPARATOR ',') as Lista_Tramites, GROUP_CONCAT(eg.nombre SEPARATOR ',') as Lista_Entidades "+
"FROM usuarios_gubernamentales ug "+  
"LEFT JOIN tramites_gubernamentales tg "+
"ON ug.id=tg.usuarios_gubernamentales_id "+
"LEFT JOIN entidades_gubernamentales eg "+
"ON eg.id = tg.entidades_gubernamentales_id "+
"GROUP By ug.id, ug.nombre "+
"HAVING  numero_Tramites > 0"
).executeUpdate();
    }
    
}
