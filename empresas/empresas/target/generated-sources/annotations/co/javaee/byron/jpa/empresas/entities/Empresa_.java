package co.javaee.byron.jpa.empresas.entities;

import co.javaee.byron.jpa.empresas.entities.DetalleCompras;
import co.javaee.byron.jpa.empresas.entities.RegimenEmpresa;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-09-18T02:45:09")
@StaticMetamodel(Empresa.class)
public class Empresa_ { 

    public static volatile ListAttribute<Empresa, DetalleCompras> detalleComprasList;
    public static volatile SingularAttribute<Empresa, RegimenEmpresa> idRegimen;
    public static volatile SingularAttribute<Empresa, Integer> id;
    public static volatile SingularAttribute<Empresa, String> nombre;

}