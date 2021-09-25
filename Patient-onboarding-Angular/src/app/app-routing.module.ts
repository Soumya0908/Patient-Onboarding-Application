import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BookingHistoryComponent } from './components/booking-history/booking-history.component';
import { ViewDetailsComponent } from './components/view-details/view-details.component';

const routes: Routes = [
  {path:'',component:BookingHistoryComponent},
  {path:'viewCustomerDetails/:bookingId',component:ViewDetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
