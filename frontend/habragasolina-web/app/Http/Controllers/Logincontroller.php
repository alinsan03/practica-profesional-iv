<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;
use App\Models\User;

class LoginController extends Controller
{
    public function showLoginForm()
    {
        return view('login');
    }

    public function login(Request $request)
    {
        // Validar los datos del formulario
        $request->validate([
            'username' => 'required|min:5',
            'password' => 'required|min:5',
        ]);

        // Intentar autenticar al usuario
        $credentials = [
            'username' => $request->username,
            'password' => $request->password
        ];

        if (Auth::attempt($credentials)) {
            
            $user = Auth::user();
            // Guardar el username y id_gas_station en la sesión
            session(['username' => $user->username, 'id_gas_station' => $user->id_gas_station]);
            return redirect()->route('admin');  // Cambia la ruta a tu página de Admin
        } else {
            
            return back()->with('error', 'Credenciales incorrectas, por favor intente de nuevo');
        }
    }

    public function logout()
    {
        Auth::logout();
        return redirect()->route('login');
    }
}
