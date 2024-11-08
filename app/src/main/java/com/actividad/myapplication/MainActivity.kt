package com.actividad.menutypesapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.actividad.myapplication.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Configuración del Menú de Opciones
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Botón para el Menú Popup
        val buttonPopup: Button = findViewById(R.id.buttonPopup)
        buttonPopup.setOnClickListener {
            showPopupMenu(it)  // Muestra el Popup Menu
        }

        // Botón para el Menú Contextual
        val buttonContext: Button = findViewById(R.id.buttonContext)
        buttonContext.setOnLongClickListener {
            openContextMenu(buttonContext)  // Abre el menú contextual cuando se mantiene presionado
            true // Retorna true para indicar que el evento ha sido manejado
        }

        // Registrar el botón para el menú contextual
        registerForContextMenu(buttonContext)
    }

    // Mostrar el Menú Popup
    private fun showPopupMenu(view: View) {
        val popupMenu = PopupMenu(this, view)
        menuInflater.inflate(R.menu.popup_menu, popupMenu.menu)

        // Manejar la selección del ítem en el PopupMenu
        popupMenu.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.popupOption1 -> {
                    // Acción para la opción 1 del PopupMenu
                    Toast.makeText(this, "Opción 1 del PopupMenu seleccionada", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.popupOption2 -> {
                    // Acción para la opción 2 del PopupMenu
                    Toast.makeText(this, "Opción 2 del PopupMenu seleccionada", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }

        popupMenu.show()
    }

    // Crear el Menú de Opciones
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)
        return true
    }

    // Manejar la selección de un ítem del Menú de Opciones
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.option1 -> {
                // Acción para la opción 1
                Toast.makeText(this, "Opción 1 del menu seleccionada", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.option2 -> {
                // Acción para la opción 2
                Toast.makeText(this, "Opción 2 del menu seleccionada", Toast.LENGTH_SHORT).show()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    // Crear el Menú Contextual
    override fun onCreateContextMenu(menu: android.view.ContextMenu?, v: View?, menuInfo: android.view.ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.context_menu, menu) // Inflamos el menú contextual
    }

    // Manejar la selección del Menú Contextual
    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.context_option1 -> {
                // Acción para la opción 1 del menú contextual
                Toast.makeText(this, "Opción 1 del menú contextual seleccionada", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.context_option2 -> {
                // Acción para la opción 2 del menú contextual
                Toast.makeText(this, "Opción 2 del menú contextual seleccionada", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }
}
