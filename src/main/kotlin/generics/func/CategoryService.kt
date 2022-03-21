package generics.func

import generics.func.ServicesBean

/**
 *
 * ClassName:      CategoryService
 * Description:    Description
 * Author:         Justin
 * CreateDate:     11/08/2020 16:38
 * UpdateUser:     Justin
 * UpdateDate:     11/08/2020 16:38
 * UpdateRemark:   Modify the description
 */
data class CategoryService(
    val category: String? = null,
    val isEmpty: Boolean = false,//移除之后的占位符
    val services: ServicesBean? = null,
    val isShow: Boolean = true,
)







