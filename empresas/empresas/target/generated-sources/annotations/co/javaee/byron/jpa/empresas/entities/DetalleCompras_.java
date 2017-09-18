package co.javaee.byron.jpa.empresas.entities;

import co.javaee.byron.jpa.empresas.entities.Empresa;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-09-18T02:45:09")
@StaticMetamodel(DetalleCompras.class)
public class DetalleCompras_ { 

    public static volatile SingularAttribute<DetalleCompras, Double> valorRetencion;
    public static volatile SingularAttribute<DetalleCompras, Double> valorIva;
    public static volatile SingularAttribute<DetalleCompras, Double> valorNetoPagar;
    public static volatile SingularAttribute<DetalleCompras, Empresa> empresasId;
    public static volatile SingularAttribute<DetalleCompras, Double> valorCompra;
    public static volatile SingularAttribute<DetalleCompras, Integer> id;
    public static volatile SingularAttribute<DetalleCompras, Integer> cantidad;
    public static volatile SingularAttribute<DetalleCompras, Double> valorUnitario;

}