package com.example.js.ext

import com.example.js.Target
import kotlinx.html.CommonAttributeGroupFacade
import kotlinx.html.onClick

fun CommonAttributeGroupFacade.moveOnClick(url: String, target: Target = Target._parent) {
    onClick = "window.open(\"$url\",\"${target.name}\")"
}
