# DefaultApi

All URIs are relative to *https://api.ejemplo.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**cerrarSesion**](DefaultApi.md#cerrarSesion) | **DELETE** /api/v1/sesiones/actual | Cierre de sesión e invalidación de tokens |
| [**iniciarSesion**](DefaultApi.md#iniciarSesion) | **POST** /api/v1/sesiones | Iniciar sesión validando credenciales |
| [**obtenerPerfil**](DefaultApi.md#obtenerPerfil) | **GET** /api/v1/usuarios/yo | Consulta del perfil del usuario autenticado |
| [**registrarUsuario**](DefaultApi.md#registrarUsuario) | **POST** /api/v1/usuarios | Registro de un nuevo usuario |
| [**renovarToken**](DefaultApi.md#renovarToken) | **POST** /api/v1/sesiones/renovaciones | Renovación de token de acceso expirado |
| [**restablecerPassword**](DefaultApi.md#restablecerPassword) | **PATCH** /api/v1/usuarios/password | Restablecimiento de la contraseña |
| [**solicitarOtp**](DefaultApi.md#solicitarOtp) | **POST** /api/v1/codigos-otp | Solicitud y envío de código OTP |
| [**solicitarRecuperacion**](DefaultApi.md#solicitarRecuperacion) | **POST** /api/v1/solicitudes-recuperacion | Solicitud de recuperación de contraseña |
| [**validarOtp**](DefaultApi.md#validarOtp) | **POST** /api/v1/codigos-otp/validaciones | Verificación y validación de código OTP |


<a id="cerrarSesion"></a>
# **cerrarSesion**
> cerrarSesion()

Cierre de sesión e invalidación de tokens

Cierra la sesión activa del usuario, agregando el token a la lista negra.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.ejemplo.com");
    
    // Configure HTTP bearer authorization: BearerAuth
    HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
    BearerAuth.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    try {
      apiInstance.cerrarSesion();
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#cerrarSesion");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

[BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Sesión cerrada exitosamente |  -  |

<a id="iniciarSesion"></a>
# **iniciarSesion**
> iniciarSesion(iniciarSesionRequest)

Iniciar sesión validando credenciales

Autentica a un usuario mediante sus credenciales y genera los tokens de acceso y refresco.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.ejemplo.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    IniciarSesionRequest iniciarSesionRequest = new IniciarSesionRequest(); // IniciarSesionRequest | 
    try {
      apiInstance.iniciarSesion(iniciarSesionRequest);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#iniciarSesion");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **iniciarSesionRequest** | [**IniciarSesionRequest**](IniciarSesionRequest.md)|  | |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Sesión iniciada exitosamente |  -  |

<a id="obtenerPerfil"></a>
# **obtenerPerfil**
> obtenerPerfil()

Consulta del perfil del usuario autenticado

Obtiene la información del usuario autenticado en la sesión actual.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.ejemplo.com");
    
    // Configure HTTP bearer authorization: BearerAuth
    HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
    BearerAuth.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    try {
      apiInstance.obtenerPerfil();
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#obtenerPerfil");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

[BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Perfil obtenido exitosamente |  -  |

<a id="registrarUsuario"></a>
# **registrarUsuario**
> registrarUsuario(registrarUsuarioRequest)

Registro de un nuevo usuario

Registra un nuevo usuario en la plataforma y genera su perfil inicial.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.ejemplo.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    RegistrarUsuarioRequest registrarUsuarioRequest = new RegistrarUsuarioRequest(); // RegistrarUsuarioRequest | 
    try {
      apiInstance.registrarUsuario(registrarUsuarioRequest);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#registrarUsuario");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **registrarUsuarioRequest** | [**RegistrarUsuarioRequest**](RegistrarUsuarioRequest.md)|  | |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Usuario creado exitosamente |  -  |

<a id="renovarToken"></a>
# **renovarToken**
> renovarToken(renovarTokenRequest)

Renovación de token de acceso expirado

Emite un nuevo token de acceso utilizando un token de refresco válido.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.ejemplo.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    RenovarTokenRequest renovarTokenRequest = new RenovarTokenRequest(); // RenovarTokenRequest | 
    try {
      apiInstance.renovarToken(renovarTokenRequest);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#renovarToken");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **renovarTokenRequest** | [**RenovarTokenRequest**](RenovarTokenRequest.md)|  | |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Token renovado con éxito |  -  |

<a id="restablecerPassword"></a>
# **restablecerPassword**
> restablecerPassword(restablecerPasswordRequest)

Restablecimiento de la contraseña

Asigna una nueva contraseña validando el token de recuperación.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.ejemplo.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    RestablecerPasswordRequest restablecerPasswordRequest = new RestablecerPasswordRequest(); // RestablecerPasswordRequest | 
    try {
      apiInstance.restablecerPassword(restablecerPasswordRequest);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#restablecerPassword");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **restablecerPasswordRequest** | [**RestablecerPasswordRequest**](RestablecerPasswordRequest.md)|  | |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Contraseña restablecida exitosamente |  -  |

<a id="solicitarOtp"></a>
# **solicitarOtp**
> solicitarOtp(solicitarOtpRequest)

Solicitud y envío de código OTP

Genera y envía un código de un solo uso al correo del usuario.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.ejemplo.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    SolicitarOtpRequest solicitarOtpRequest = new SolicitarOtpRequest(); // SolicitarOtpRequest | 
    try {
      apiInstance.solicitarOtp(solicitarOtpRequest);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#solicitarOtp");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **solicitarOtpRequest** | [**SolicitarOtpRequest**](SolicitarOtpRequest.md)|  | |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | OTP enviado correctamente |  -  |

<a id="solicitarRecuperacion"></a>
# **solicitarRecuperacion**
> solicitarRecuperacion(solicitarRecuperacionRequest)

Solicitud de recuperación de contraseña

Inicia el proceso de recuperación enviando un enlace al correo.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.ejemplo.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    SolicitarRecuperacionRequest solicitarRecuperacionRequest = new SolicitarRecuperacionRequest(); // SolicitarRecuperacionRequest | 
    try {
      apiInstance.solicitarRecuperacion(solicitarRecuperacionRequest);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#solicitarRecuperacion");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **solicitarRecuperacionRequest** | [**SolicitarRecuperacionRequest**](SolicitarRecuperacionRequest.md)|  | |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **202** | Solicitud procesada correctamente |  -  |

<a id="validarOtp"></a>
# **validarOtp**
> validarOtp(validarOtpRequest)

Verificación y validación de código OTP

Valida el código OTP ingresado por el usuario.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.ejemplo.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    ValidarOtpRequest validarOtpRequest = new ValidarOtpRequest(); // ValidarOtpRequest | 
    try {
      apiInstance.validarOtp(validarOtpRequest);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#validarOtp");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **validarOtpRequest** | [**ValidarOtpRequest**](ValidarOtpRequest.md)|  | |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OTP validado correctamente |  -  |

