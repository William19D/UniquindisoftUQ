import random
import os

# Funciones auxiliares para generar datos aleatorios
def generar_nombre():
    nombres = ["Juan", "Marta", "Carlos", "Diana", "Luis", "Ana", "Fernando", "Paola", "Andres", "Gloria", "Santiago", 
               "Liliana", "Ricardo", "Patricia", "Gabriel", "Adriana", "Miguel", "Laura", "Jorge", "Carmen", "Felipe", 
               "Angela", "Esteban", "Monica", "Rodrigo", "Paula", "Hector", "Sandra", "Sebastian", "Veronica", "Oscar", 
               "Silvia", "Mauricio", "Rosa", "Diego", "Lorena", "Jose", "Claudia", "Ivan", "Catalina", "Roberto", 
               "Nathalia", "Javier", "Marcela", "Samuel", "Teresa", "Alonso", "Violeta", "Hernan", "Tatiana", "Victor", 
               "Camila", "Rafael", "Luisa", "Cristian", "Gabriela", "Manuel", "Valentina", "Alfredo", "Julia", "Eduardo", 
               "Lucrecia", "Pedro", "Beatriz", "Luis", "Raquel", "Cesar", "Mariana", "Ricardo", "Alicia", "Gustavo", 
               "Liliana", "Felipe"]
    apellidos = ["Ortiz", "Gomez", "Sanchez", "Fernandez", "Beltran", "Torres", "Vega", "Diaz", "Castro", "Ramirez", 
                 "Garcia", "Moreno", "Mendez", "Munoz", "Castillo", "Salazar", "Cano", "Zapata", "Jimenez", "Rojas", 
                 "Rivera", "Acosta", "Paredes", "Diaz", "Valencia", "Quiroz", "Robledo", "Molina", "Cano", "Duarte", 
                 "Lopez", "Rodriguez", "Gutierrez", "Herrera", "Moreno", "Ramirez", "Hernandez", "Ortiz", "Giraldo", 
                 "Velasquez", "Cabrera", "Montoya", "Ruiz", "Castro", "Arango", "Lara", "Vargas", "Castaño", "Rios", 
                 "Aguilar", "Martinez", "Franco", "Bautista", "Ruiz", "Vega", "Bonilla", "Torres", "Prieto", "Lopez", 
                 "Moreno", "Salazar", "Cardenas", "Montoya", "Gallego", "Mejia", "Arias", "Murillo", "Jaramillo", 
                 "Giraldo", "Herrera", "Ospina"]
    return f"{random.choice(nombres)} {random.choice(apellidos)}"

def generar_identificacion():
    return f"{random.randint(2000000000, 2099999999)}"

def generar_tipo_documento():
    tipos_documento = ["CC", "TI", "CE", "RC", "NUIP"]
    return random.choice(tipos_documento)

def generar_caracterizacion():
    return random.choice(["INHABILITAR", "EMBARGAR"])

def generar_dato():
    tipo_documento = generar_tipo_documento()
    return f"{tipo_documento};;{generar_identificacion()};;{generar_nombre()};;{generar_caracterizacion()}"

# Función principal para generar archivos
def generar_archivos(cantidad_archivos, cantidad_datos_por_archivo=100):
    # Directorio actual
    directorio_actual = os.path.dirname(os.path.abspath(__file__))
    
    # Crear archivos directamente en el mismo directorio
    for i in range(1, cantidad_archivos + 1):
        archivo_nombre = os.path.join(directorio_actual, f"datos_{i}.csv")
        with open(archivo_nombre, "w", encoding="utf-8") as archivo:
            # Agregar encabezados
            archivo.write("tipo_documento;;documento;;nombre_completo;;caracterizacion\n")
            # Agregar datos
            for _ in range(cantidad_datos_por_archivo):
                archivo.write(generar_dato() + "\n")
        print(f"Archivo generado: {os.path.abspath(archivo_nombre)}")

# Ejemplo de uso
if __name__ == "__main__":
    try:
        cantidad_archivos = int(input("Ingrese la cantidad de archivos a generar: "))
        generar_archivos(cantidad_archivos)
    except ValueError:
        print("Por favor, ingrese un número válido.")
