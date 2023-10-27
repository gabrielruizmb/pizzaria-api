import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FlavourFormComponent } from './flavour-form.component';

describe('FlavourFormComponent', () => {
  let component: FlavourFormComponent;
  let fixture: ComponentFixture<FlavourFormComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FlavourFormComponent]
    });
    fixture = TestBed.createComponent(FlavourFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
