package com.example.demo.models;

import jakarta.persistence.*;


@Entity
@Table(name = "transaccion")
public class SimulacionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)

    private Long id;
    private Long salario;
    private Long clienteId;
    private long CupoAprobado;
    private String tasa;
    private String tipoTarjeta;

    public SimulacionModel() {
    }

    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(String tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }


    public long getCupoAprobado() {
        return CupoAprobado;
    }

    public void setCupoAprobado(long cupoAprobado) {
        CupoAprobado = cupoAprobado;
    }

    public String getTasa() {
        return tasa;
    }

    public void setTasa(String tasa) {
        this.tasa = tasa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getSalario() {
        return salario;
    }

    public void setSalario(Long salario) {
        this.salario = salario;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }
}


