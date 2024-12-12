@include('components.header')
<body>
    <div class="titleini">
    <h1>Iniciar Sesión</h1>
    </div>
    @if(session('error'))
        <p style="color: red;">{{ session('error') }}</p>
    @endif
    <div class="logint">
        <div class="did">
    <form method="POST" action="{{ route('login') }}">
        @csrf
        <div class="space">
            <label class="userlabel" for="username">Usuario:</label>
            <input class="inputlogin" type="text" id="username" name="username" required minlength="5" value="{{ old('username') }}">
        </div>
        <div class="space">
            <label class="userlabel" for="password">Contraseña:</label>
            <input class="inputlogin" type="password" id="password" name="password" required minlength="5">
        </div>
        <div class="oki">
        <button class="ok" type="submit">Login</button>
        </div>
    </form>
    </div>
    </div>
</body>
@include('components.footer')