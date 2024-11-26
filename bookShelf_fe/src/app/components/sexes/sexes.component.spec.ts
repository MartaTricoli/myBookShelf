import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SexesComponent } from './sexes.component';

describe('SexesComponent', () => {
  let component: SexesComponent;
  let fixture: ComponentFixture<SexesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [SexesComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SexesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
