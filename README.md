# **Parcial Práctico Segundo Tercio**

**Elaborado por**

Juan Carlos Leal Cruz

## **Secuencia de Lucas**
Para resolver el ejercicio de la Secuencia de Lucas lo que se hizo la creación de dos clases específicas que existen en pro del cálculo:
1. **`MathController`:** Expone el endpoint al cual el usuario hace el request mediante la URL haciendo uso de un `@PathVariable` para poder leer el valor ingresado.
3. **`MathService`:** Realiza el cálculo de la secuencia de lucas haciendo uso del valor ingresado por el usuario.


### **Secuencia de Lucas**
La secuencia de Lucas se calcula de la siguiente manera :

L(0)=2

L(1)=1

L(n)=L(n−1)+L(n−2), para un n≥2

**Evidencia de funcionamiento mínima**
![evidenceBasic.png](images/evidenceBasic.png)

### **Correr en local**
Para correr el proyecto en local lo que se tiene que hacer es lo siguiente:
1. Clonar el repo
   ```bash
   git clone <URL_repo>
   ```

2. Compilar el repositorio
   ```bash
   cd <repo-name>
   mvn clean compile
   ```
   ![compileLocal.png](images%2FcompileLocal.png)

3. Instalar las dependencias
  ```bash
   mvn clean install
   ```

4. Correr el proyecto
   Para esto se puede hacer manualmente usando el botpn de Run de su IDE dentro de la clase `ParcialApplication` o usando el sigueinte comando:
   ```bash
   mvn spring-boot:run
   ```

#### **Evidencia en Local**
- Usando n = 13
  ![lucas13Local.png](images%2Flucas13Local.png)

- Usando n = 40
  ![lucas40Local.png](images%2Flucas40Local.png)
   