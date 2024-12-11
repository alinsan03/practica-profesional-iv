<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Http;

class AdminPageController extends Controller
{
    public function index()
    {

        $response = Http::get('http://localhost:8080/fueltype');


        if ($response->successful()) {
            $fueltypes = $response->json();
            return view('admin-page', compact('fueltypes'));
        }

        return view ('admin-page', ['fueltypes' => []]);
    }
}
