<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h1>Iniciar Sesión</h1>
    @if(session('error'))
        <p style="color: red;">{{ session('error') }}</p>
    @endif
    <form method="POST" action="{{ route('login') }}">
        @csrf
        <div>
            <label for="username">Usuario:</label>
            <input type="text" id="username" name="username" required minlength="5" value="{{ old('username') }}">
        </div>
        <div>
            <label for="password">Contraseña:</label>
            <input type="password" id="password" name="password" required minlength="5">
        </div>
        <button type="submit">Login</button>
    </form>
</body>
</html>
