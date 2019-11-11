package ExcelDownloader.modelo;

public class Usuario {

	private Long id;
	private String nombre;
	private String apellido;

	public Usuario(Long id, String nombre, String apellido) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + "  apellido=" + apellido + "]";
	}
}
